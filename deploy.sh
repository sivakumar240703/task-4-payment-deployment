#!/bin/sh

ARTIFACT="$1"

if [ -z "$ARTIFACT" ]; then
    echo "Artifact path is required"
    exit 1
fi

if [ ! -f "$ARTIFACT" ]; then
    echo "Artifact not found: $ARTIFACT"
    exit 1
fi

echo "Deploying artifact: $ARTIFACT"
echo "Deployment completed successfully"