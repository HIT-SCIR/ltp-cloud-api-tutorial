LTP Cloud API 编程调用示例
==========================

通过例子学习使用LTP Cloud API！

### 获得一个apikey

在语言云网站上完成注册后，点击控制面板，就可以看到apikey。

![apikey](https://raw.github.com/HIT-SCIR/ltp-cloud-api-tutorial/master/.img/apikey.jpg)

### HelloWord程序

通过这些例子，你可以了解如何使用GET方式分析请求LTP Cloud API；
如何填写LTP Cloud API的参数集；
在不同参数设置下，LTP Cloud响应的格式。

* ./Java/Basics/SimpleAPI.java
* ./Go/Basics/simple.go
* ./Nodejs/Basics/simple.js
* ./R/Basics/simple.R
* ./Python/Basics/simple.py
* ./Ruby/Basics/simple.rb

### 交互式例子

* ./Java/Basics/CommandLineAPI.java
* ./JavaScript/Basics/demo.html
* ./JavaScript/JQuery/demo.html
* ./PHP/Basics/simple.php
* ./Python/Basics/interactive.py

### 构造中间结果进行后续分析

通过这些例子，你可以了解如何使用POST方式分析请求LTP Cloud API；
如何构造适应LTP的中间结果表示LTML。

* ./Java/Customs/CustomSegmentation.java
* ./Nodejs/Customs/custom-segment.js
* ./Python/Customs/CustomSegmentation.py
* ./Python/Customs/CustomPOSTags.py
* ./Ruby/Customs/CustomSegmentation.rb

### 注册及更多使用方法

用户在[语言云](http://www.ltp-cloud.com)网站上注册成功后即可获得使用API的API_KEY。

有关更多API的使用方法，请参考：[语言云新版API使用文档](http://ltp-cloud.com/document/new/)。

### 注意

该tutorial中的rest api url均指向`ltpapi.voicecloud.cn`，为讯飞语音云合作提供的服务，在2015年末服务分离后，其API_KEY并不与`ltp-cloud.com`通用。故如果您按照上述方式在`ltp-cloud.com`注册，其得到的API_KEY仅能用于请求`api.ltp-cloud.com`. 请注意根据实际需求，修改url.

`ltp-cloud.com`用于提供最新科研成果，属于demo性质；如果需要大规模分析，请使用[讯飞语音云](http://www.xfyun.cn/) 或者[本地部署](https://github.com/HIT-SCIR/ltp)（这两个均不支持语义依存图分析，如果需要语义依存图分析，请查看[ltp-graphsdp](https://github.com/LtpDemo/ltp_graphsdp.git)）

#### 其他链接

* [哈工大社会计算与信息检索研究中心](http://ir.hit.edu.cn/)
* [语言技术平台](https://github.com/HIT-SCIR/ltp)
