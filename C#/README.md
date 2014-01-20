C# 调用LTP Cloud API示例
------------------------

### ./Basics/simple.cs

这个示例程序介绍如何使用C#构造请求调用LTP Cloud API。

将apikey填入15行的: `string api_key  = "YourApiKey";`，编译

```
csc simple.cs
```

运行
```
simple.exe
```

就可以看到以xml格式返回的结果。

### ./Customs/CustomSegmentation.cs

这个示例显示如何使用C#向LTP提交分析的中间结果(分词结果)，调用LTP Cloud API进行进一步的语言分析。编译

```
csc CustomSegmentation.cs
```

运行

```
CustomSegmentation.exe
```
