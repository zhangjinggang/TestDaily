package compare.work;//public static void main(String[] args) throws Exception {
//        File sqlFileOrg = new File("G:\\BOH\\enum.txt");
//        File sqlFileWrite = new File("G:\\BOH\\enumClass.txt");
//        //加快读速度 操作数组
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(sqlFileOrg));
//        //加快写速度
//        BufferedWriter bufferedWriterPartion = new BufferedWriter(new FileWriter(sqlFileWrite));
//
//
//        String strFix = "";
//        while((strFix = bufferedReader.readLine()) != null){
//        StringBuilder stringBuilder = new StringBuilder("");
//        if(strFix != null && !"".equals(strFix)){
//        stringBuilder.append(strFix);
//        String[] ipStr = strFix.split(",");
//        //获取英文
//        String engStr = "错误";
//        String replace = ipStr[2].substring(2,ipStr[2].length()-2);
//        try {
//        engStr = getEnglish(replace);
//        } catch (Exception e){
//        e.printStackTrace();
//        }
//        String temp = stringBuilder.toString();
//        temp = temp.replace("错误",engStr);
//        bufferedWriterPartion.write(temp);
//        bufferedWriterPartion.newLine();
//
//        }
//        }
//
//
//        bufferedWriterPartion.flush();
//        bufferedWriterPartion.close();
//
//
//
//        }
//
//
//
//private static String getEnglish(String s) {
//        s = s.trim();
//        String url = "http://fy.iciba.com/ajax.php?a=fy&f=chineses&t=english&w="+s;
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
//        String body = forEntity.getBody();
//        JSONObject json = JSONObject.parseObject(body);
//        String content = JSONObject.toJSONString(json.get("content"));
//        String str = (String) JSONObject.parseObject(content).get("out");
//        str = str.trim();
//        str = str.replace(" ","_");
//        str = str.toUpperCase();
//        return str;
//        }