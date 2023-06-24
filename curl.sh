#!/bin/bash

# curlを非同期で実行する関数
function execute_curl() {
    url=$1
    output_file=$2
    
    # curlコマンドをバックグラウンドで実行し、結果を指定したファイルに保存
    curl "$url" -w '\n' >> "$output_file" &
}

# 実行するURLと出力ファイル名
url="http://localhost:8080/"
output_prefix="output"

# 100回繰り返して非同期でcurlを実行
for ((i=1; i<=1000; i++)); do
    output_file="${output_prefix}.txt"
    execute_curl "$url" "$output_file"
done

# 全てのバックグラウンドプロセスの終了を待つ
wait

