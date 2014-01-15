Python 调用LTP Cloud API示例
----------------------------

### ./Basics/simple.py

这是一个HelloWorld程序，你可以通过这个程序了解如何调用LTP Cloud API并且对返回结果有一个直观了解。

将apikey填入18行的: `api_key  = "YourApiKey"`，运行
```
python simple.py xml
```
就可以看到以xml格式显示的结果。如果要显示json格式或conll格式，只要把xml换成json、conll即可。


### ./Basics/interactive.py
一个交互式程序，可以选择任务，分析输入句子用以的方式获得结果。

将apikey填入39行的：`"api_key" : "YourApiKey",`，运行
```
python interactive.py
```
就可以按照程序提示进行分析。

### ./Customs/ConstructLTML.py

产生LTP可接受的包含分析中间结果的实例。结果使用LTML格式表示。关于LTML各节点含义，可以参考我们的[文档](http://www.ltp-cloud.com/document/new/#api_rest_format_xml)。

运行
```
python ConstructLTML.py
```
就可以看到分词/词性标注的中间结果。


### ./Customs/CustomSegmentation.py

如果你有分词结果，想调用LTP Cloud API进行词性标注，你可以参考这个例子。

将apikey填入19行的：`"api_key"  : "YourApiKey",`，运行
```
python CustomSegmentation.py
```
就可以看到词性标注结果。

### ./Customs/CustomPOStags.py

与CustomSegmentation.py相似，如果你有分词和词性标注结果，想调用LTP Cloud API进行句法分析，你可以仿照这个例子。
将apikey填入25行的：`"api_key"  : "YourApiKey",`，运行
```
python CustomSegmentation.py
```
就可以看到句法分析的结果。
