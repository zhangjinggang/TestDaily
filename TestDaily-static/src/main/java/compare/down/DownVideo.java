package compare.down;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownVideo {

    public static void main(String[] args) {
        for(int i=42916; i > 42900; --i){
          try {
              String html = "https://lmyy.pw/vodplay/" + i + "-1-1.html";
              Video video = getVideoUrl(html);
              if(video == null){
                  continue;
              }
              DownMp4.s1 = video.getFilePath();
              DownMp4.DES_PATH = "F:\\mp4\\"+video.getFileName();
              DownMp4.start();
          }catch (Exception e){
              e.printStackTrace();
          }

        }
    }

    private static Video getVideoUrl(String html) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("User-Agent","Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36");
            HttpEntity<String> request = new HttpEntity(null, headers);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(html, HttpMethod.GET, request, String.class);
            if(response == null || StringUtils.isBlank(response.getBody())){
                return null;
            }
            Video video = new Video();
            String line = response.getBody();
            if(line.contains("当前播放")){
                String str = line.substring(line.indexOf("当前播放")+5,line.indexOf("</li><li><span class="));
                video.setFileName(str);
            }
            if(line.contains("\"url\":\"http")){
                String str = line.substring(line.indexOf("\"url\":\"http") + 7,line.indexOf("\",\"url_next\""));
                str = str.replaceAll("\\\\","");
                video.setFilePath(str);
                return video;
            }
            return video;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }
}
