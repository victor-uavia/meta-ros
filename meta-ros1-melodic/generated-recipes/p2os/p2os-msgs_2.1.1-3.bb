# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Defines the messages that are used to communicate with the     p2os_driver package and the ROS infrastructure."
AUTHOR = "Hunter L. Allen <hunter@openrobotics.org>"
ROS_AUTHOR = "Hunter L. Allen <hunter@openrobotics.org>"
HOMEPAGE = "http://ros.org/wiki/p2os-purdue"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "p2os"
ROS_BPN = "p2os_msgs"

ROS_BUILD_DEPENDS = " \
    message-generation \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    message-generation \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    message-generation \
    message-runtime \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/allenh1/p2os-release/archive/release/melodic/p2os_msgs/2.1.1-3.tar.gz
ROS_BRANCH ?= "branch=release/melodic/p2os_msgs"
SRC_URI = "git://github.com/allenh1/p2os-release;${ROS_BRANCH};protocol=https"
SRCREV = "6acf451a9b5b163e38893d232d40a77b2ea4bfef"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
