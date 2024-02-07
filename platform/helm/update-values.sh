#!/bin/bash

# Your logic to update values in values.yaml
NEW_TAG="$(git rev-parse --short ${{ github.sha }})"

sed -i "s/tag: latest/tag: $NEW_TAG/" values.yaml

# Add the changes to the staging area
git add values.yaml

# Exit with success
exit 0

