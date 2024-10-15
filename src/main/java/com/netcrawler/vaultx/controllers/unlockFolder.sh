#!/bin/bash
# Usage: ./unlockFolder.sh <folder_path>
if [ -z "$1" ]; then
    echo "Please provide a folder path."
    exit 1
fi

 
chmod -R u+w "$1"
echo "Folder unlocked: $1"