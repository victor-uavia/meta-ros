# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "A ROS Driver for V4L USB Cameras"
AUTHOR = "Russell Toris <rctoris@wpi.edu>"
ROS_AUTHOR = "Benjamin Pitzer <benjamin.pitzer@bosch.com>"
HOMEPAGE = "http://wiki.ros.org/usb_cam"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "usb_cam"
ROS_BPN = "usb_cam"

ROS_BUILD_DEPENDS = " \
    camera-info-manager \
    ffmpeg \
    image-transport \
    roscpp \
    sensor-msgs \
    std-msgs \
    std-srvs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_v4l-utils} \
    camera-info-manager \
    ffmpeg \
    image-transport \
    roscpp \
    sensor-msgs \
    std-msgs \
    std-srvs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_v4l-utils} \
    camera-info-manager \
    ffmpeg \
    image-transport \
    roscpp \
    sensor-msgs \
    std-msgs \
    std-srvs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/usb_cam-release/archive/release/melodic/usb_cam/0.3.6-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/usb_cam"
SRC_URI = "git://github.com/ros-gbp/usb_cam-release;${ROS_BRANCH};protocol=https"
SRCREV = "f633d034079c5db19b9128f91a18b6d446e61139"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
