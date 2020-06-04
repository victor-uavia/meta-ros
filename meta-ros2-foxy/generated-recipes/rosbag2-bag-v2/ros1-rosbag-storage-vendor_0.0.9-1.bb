# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "Vendor package for rosbag_storage of ROS1"
AUTHOR = "Karsten Knese <karsten@openrobotics.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rosbag2_bag_v2"
ROS_BPN = "ros1_rosbag_storage_vendor"

ROS_BUILD_DEPENDS = " \
    boost \
    bzip2 \
    console-bridge \
    gpgme \
    openssl \
    pkgconfig \
    pluginlib \
    ros1-bridge \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    git-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rosbag2_bag_v2-release/archive/release/foxy/ros1_rosbag_storage_vendor/0.0.9-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/ros1_rosbag_storage_vendor"
SRC_URI = "git://github.com/ros2-gbp/rosbag2_bag_v2-release;${ROS_BRANCH};protocol=https"
SRCREV = "dd56af798fa75cc60fcb1bc99f048ec962813ed5"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
