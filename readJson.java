/**
  Springboot读取json文件，pom文件需要添加的依赖为：
   <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.4</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.59</version>
        </dependency>
/

public void readJson() throws IOException{
	//device.json为想要处理的json文件，其被放在resource文件夹中
	ClassPathResource resource=new ClassPathResource("device.json");
	//获取文件位置
	File file=resource.getFile();
	//读取文件，转换成JSON字符串
	String input=FileUtils.readFileToString(file);
	//将字符串转化为JSONObject
	JSONObject jsonObject=JSONObject.parseObject(input);
	Object object=jsonObject.get("data")//获取文件中data元素
	JSONObject json=JSONObject.parseObject(object.toString());
	//获取数组中key为deviceDistribution的元素
	JSONArray jsonArray=json.getJSONArray("deviceDistribution");

	Iterator<Object> iterator=jsonArray.iterator();
	while(iterator.hasNext()){
		JSONObject btn=iterator.next();
		String str=btn.get("key").toString;//获取key的value值
		System.out.println(str);
	}
}