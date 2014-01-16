Java 调用LTP Cloud API示例
--------------------------

### ./Basics/SimpleAPI.java

这个示例程序介绍如何使用Java构造请求调用LTP Cloud API。

将apikey填入18行的: `String api_key = "YourApiKey";`，编译
```
javac SimpleAPI.java
```

运行
```
java SimpleAPI xml
```
就可以看到以xml格式返回的结果。

### ./Basics/CommandLineAPI.java

这个示例是一个对LTP Cloud API的命令行封装。你可以以命令行的方式填入apikey、待分析文本以及待分析任务。编译
```
javac CommandLineAPI.java
```

运行
```
java CommandLineAPI
```

### ./Customs/CustomSegmentation.java

这个示例显示如何使用Java向LTP提交分析的中间结果(分词结果)，调用LTP Cloud API进行进一步的语言分析。编译
```
javac CustomSegmentation.java
```

运行
```
java CustomSegmentation
```
