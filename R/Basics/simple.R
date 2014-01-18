site <- "http://mirror.bjtu.edu.cn/cran/"

if (!require('RCurl')) {
    install.packages('RCurl', repo=site, dependencies=TRUE)
}

library('RCurl')

uri <- 'http://api.ltp-cloud.com/analysis/?'
params <- c('api_key=YourApiKey',
            'text=我爱北京天安门',
            'pattern=srl',
            'format=conll')

url <- paste(uri, paste(params, collapse = "&"), sep='')

print(url)
response <- getURL(url)

response.text <- gsub("\t", ",", response)

con <- textConnection(response.text)
data <- read.csv(con, header=FALSE)
names(data) <- c('id', 'form', 'lemma', 'cpostag', 'postag',
                 'ne', 'head', 'deprel', 'phead', 'pdeprel')

print(data)
