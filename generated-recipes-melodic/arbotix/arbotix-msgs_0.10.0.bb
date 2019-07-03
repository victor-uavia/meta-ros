# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Messages and Services definitions for the ArbotiX."
AUTHOR = "Michael Ferguson <mike@vanadiumlabs.com>"
ROS_AUTHOR = "Michael Ferguson"
HOMEPAGE = "http://ros.org/wiki/arbotix_msgs"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "arbotix"
ROS_BPN = "arbotix_msgs"

ROS_BUILD_DEPENDS = " \
    message-generation \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    message-runtime \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
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

SRC_URI = "https://github.com/vanadiumlabs/arbotix_ros-release/archive/release/melodic/arbotix_msgs/0.10.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "829637f9a5d2b28ac8fcd2cf50b79cbf"
SRC_URI[sha256sum] = "4c30092a42cad55c7ed008b877d72fa55f90fd899352daa35e4e1bf64797c092"
S = "${WORKDIR}/arbotix_ros-release-release-melodic-arbotix_msgs-0.10.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('arbotix', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('arbotix', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/arbotix/arbotix_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/arbotix/arbotix-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/arbotix/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/arbotix/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}