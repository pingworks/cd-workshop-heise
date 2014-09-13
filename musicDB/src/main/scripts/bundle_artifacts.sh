#!/bin/bash

set -eux

VERSION=$1

BASE="musicDB"

if ! echo $VERSION | grep -E '^[0-9]{14}-[0-9a-f]{7}-[0-9]{1,6}$' > /dev/null; then
  echo "Illegal version number: $VERSION"
  exit 1
fi

BUNDLENAME=${BASE}-bundle
ARTIFACTS="${BASE}-${VERSION}.war"
INSTALLER="../src/main/scripts/install.sh"

BUNDLEFILENAME="${BUNDLENAME}_${VERSION}.tar.gz"

cd ${BASE}/target
rm -rf bundle
mkdir -p bundle/{artifacts,metadata}
cp ${ARTIFACTS} bundle/artifacts/
cp ${INSTALLER} bundle/artifacts/
chmod 755 bundle/artifacts/install.sh

echo "$(echo $VERSION | cut -d- -f1)" > bundle/metadata/timestamp
echo "$(echo $VERSION | cut -d- -f2)" > bundle/metadata/commitid
echo "$(echo $VERSION | cut -d- -f3)" > bundle/metadata/buildnr

tar cvz -f "${BUNDLEFILENAME}" -C bundle artifacts metadata

rm -rf bundle
