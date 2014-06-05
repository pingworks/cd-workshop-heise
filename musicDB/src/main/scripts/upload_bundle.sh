#!/bin/bash

set -eux

VERSION=$1

BASE="musicDB"
REPO="/data/repo"

if ! echo $VERSION | grep -E '^[0-9]{14}-[0-9a-f]{7}-[0-9]{1,6}$' > /dev/null; then
  echo "Illegal version number: $VERSION"
  exit 1
fi

BUNDLENAME=${BASE}-bundle
BUNDLEFILENAME="${BUNDLENAME}_${VERSION}.tar.gz"

BUNDLEDIR="${REPO}/master/${VERSION}"
[ -d "${BUNDLEDIR}/bundles" ] || mkdir -p "${BUNDLEDIR}/bundles"
cp "${BASE}/target/${BUNDLEFILENAME}" "${BUNDLEDIR}/bundles/"
tar xvz -f "${BUNDLEDIR}/bundles/${BUNDLEFILENAME}" -C "${BUNDLEDIR}"

