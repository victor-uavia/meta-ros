# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The phidget interface kit driver package for leuze lasers"
AUTHOR = "Ludovic Delval <ludovic.delval@ipa.fraunhofer.de>"
ROS_AUTHOR = "Ludovic Delval <ludovic.delval@ipa.fraunhofer.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "leuze_ros_drivers"
ROS_BPN = "leuze_phidget_driver"

ROS_BUILD_DEPENDS = " \
    leuze-msgs \
    roscpp \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    leuze-msgs \
    roscpp \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    leuze-msgs \
    roscpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ipa-led/leuze_ros_drivers-release/archive/release/melodic/leuze_phidget_driver/1.0.1-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/leuze_phidget_driver"
SRC_URI = "git://github.com/ipa-led/leuze_ros_drivers-release;${ROS_BRANCH};protocol=https"
SRCREV = "62326f6039da61bdcb4ea5c3e28e739aba9fdb3a"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
