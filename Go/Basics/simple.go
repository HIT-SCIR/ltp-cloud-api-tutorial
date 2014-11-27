package main

import (
    "fmt"
    "net/http"
    "io/ioutil"
    "strings"
    "os"
)

func main() {
    api_key := "YourApiKey"
    text    := "我爱北京天安门"
    pattern := "all"
    format  := "conll"

    uri := strings.Join([]string{"http://ltpapi.voicecloud.cn/analysis/?",
                                 "api_key=",  api_key, "&",
                                 "text=",     text,    "&",
                                 "pattern=",  pattern, "&",
                                 "format=",   format},
                        "")

    resp, err := http.Get(uri)
    if err != nil {
        fmt.Printf("%s", err)
        os.Exit(1)
    } else {
        defer resp.Body.Close()
        contents, err := ioutil.ReadAll(resp.Body)
        if err != nil {
            fmt.Printf("%s", err)
            os.Exit(1)
        }
        fmt.Printf("%s\n", string(contents))
    }
}
