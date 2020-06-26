# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "Interface between Webots and ROS2"
AUTHOR = "Cyberbotics <support@cyberbotics.com>"
HOMEPAGE = "http://wiki.ros.org/webots_ros2"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "webots_ros2_desktop"
ROS_BPN = "webots_ros2"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    builtin-interfaces \
    rclpy \
    std-msgs \
    webots-ros2-abb \
    webots-ros2-core \
    webots-ros2-examples \
    webots-ros2-importer \
    webots-ros2-tiago \
    webots-ros2-universal-robot \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-copyright \
    ament-flake8 \
    ament-pep257 \
    python3-pytest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/cyberbotics/webots_ros2-release/archive/release/foxy/webots_ros2/0.0.3-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/webots_ros2"
SRC_URI = "git://github.com/cyberbotics/webots_ros2-release;${ROS_BRANCH};protocol=https"
SRCREV = "bfed087011e2912216052c80fd18161609af1d29"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}
