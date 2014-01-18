r-lang 调用LTP Cloud API示例
----------------------------

### Install

示例代码使用`RCurl` package发起HTTP请求，使用前请确保安装libcurl。

你可以使用

**Fedora**
```
[sudo] yum install libcurl-devel
```

**Debian/Ubuntu**
```
[sudo] apt-get install libcurl-openssh-dev
```

### ./Basics/simple.R

这个例子展示如何用R请求LTP Cloud API，将你的apikey填入第10行的`apikey=YourApiKey`，运行

```
Rscript simple.py
```

就可以获得分析结果。
