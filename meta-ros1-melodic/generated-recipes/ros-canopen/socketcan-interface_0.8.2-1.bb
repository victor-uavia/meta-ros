# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Generic CAN interface description with helpers for filtering and driver implementation. Further a socketcan implementation based on boost::asio is included."
AUTHOR = "Mathias Lüdtke <mathias.luedtke@ipa.fraunhofer.de>"
ROS_AUTHOR = "Mathias Lüdtke <mathias.luedtke@ipa.fraunhofer.de>"
HOMEPAGE = "http://wiki.ros.org/socketcan_interface"
SECTION = "devel"
LICENSE = "LGPL-2"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=b691248d2f70cdaeeaf13696ada5d47c"

ROS_CN = "ros_canopen"
ROS_BPN = "socketcan_interface"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_linux-kernel-headers} \
    boost \
    class-loader \
    console-bridge \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_linux-kernel-headers} \
    boost \
    class-loader \
    console-bridge \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_linux-kernel-headers} \
    boost \
    class-loader \
    console-bridge \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rosunit \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-industrial-release/ros_canopen-release/archive/release/melodic/socketcan_interface/0.8.2-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/socketcan_interface"
SRC_URI = "git://github.com/ros-industrial-release/ros_canopen-release;${ROS_BRANCH};protocol=https"
SRCREV = "1fa0220367552fcd825061b88339d7349a957afc"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
