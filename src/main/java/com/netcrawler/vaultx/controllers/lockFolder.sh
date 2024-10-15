#!/bin/bash

if [ -z "$1" ]; then
    echo "Please provide a folder path."
    exit 1
fi


chmod -R a-w "$1"
echo "Folder locked: $1"