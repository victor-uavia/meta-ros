# Copyright (c) 2019 LG Electronics, Inc.

PNBLACKLIST[webos-image-ros-bitbeanbirdbot] = "${@ 'Requires meta-webos layer' if 'meta-webos' not in BBFILE_COLLECTIONS.split() else '' }"

require webos-image-ros-turtlebot3-all.bb

SUMMARY = "webOS image for BigBeanBirdBot"
DESCRIPTION = "${SUMMARY}"

IMAGE_INSTALL_append = " \
    usb-cam \
"
