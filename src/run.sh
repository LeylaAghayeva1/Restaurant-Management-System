#!/bin/zsh

set -e

cd "$(dirname "$0")"
javac $(find . -name "*.java")
java app.MainApp
