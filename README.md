LTP Cloud REST API 编程调用示例
=============
语言云新版API是REST风格的WEB API调用服务，REST API服务有诸多优点，这使得它越来越流行。应用于语言云服务中，主要有如下特点：

1. **免SDK安装**：REST API的调用无须用户下载SDK，使得语言分析更为便捷。
2. **结果表示格式丰富**：API提供了包括PLAIN/XML/JSON/CONLL等多种格式的结果表示。且返回结果容易扩展，便于进行二次开发。
3. **支持JavaScript调用**：语言云支持JavaScript以JSON-P回调的方式调用API，使得返回结果可以嵌入到Web页面或者宿主Web应用中。
4. **请求方式多样**：语言云提供了HTTP GET和HTTP POST两种方式的调用接口。
5. **用户认证简洁**：API_KEY取代了旧版email:token的认证方式，作为用户的统一授权方式。

为方便用户使用REST API，语言云提供了一些编程语言调用API的代码示例。

使用其他语言使用语言云API服务的用户可以参照以上语言的调用方式。即根据所编写语言的特点构造GET或者POST方式的HTTP请求获得对应格式的结果并进行解析。

用户在[语言云](http://ltp-cloud.com)网站上注册成功后即可获得使用API的API_KEY。

有关更多API的使用方法，请参考：[语言云新版API使用文档](http://ltp-cloud.com/document/new/)。

#### 其他链接

* [哈工大社会计算与信息检索研究中心](http://ir.hit.edu.cn/)
* [语言技术平台](https://github.com/HIT-SCIR/ltp)