Python 调用ltp-cloud api示例
----------------------------

这部分示例包括:

1. 以基本方式调用ltp-cloud api并获得试用xml/json/conll表示的结果: ./Basics/simple.py

将apikey填入18行的: api_key  = "YourApiKey"，运行
```
python simple.py xml
```
就可以看到以xml格式显示的结果

2. 一个交互式程序用捷径的方式获得: ./Basics/interactive.py
3. 产生指定分词/词性标注结果的实例: ./Customs/ConstructLTML.py
4. 使用指定分词结果进行词性标注: ./Customs/CustomSegmentation.py
5. 使用指定词性标注结果进行句法分析: ./Customs/CustomPOStags.py
