# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "rospilot"
AUTHOR = "Christopher Berner <christopherberner@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "rospilot"
ROS_BPN = "rospilot"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libgphoto-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libmicrohttpd} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libnl-3-dev} \
    ffmpeg \
    geometry-msgs \
    libjpeq-turbo \
    message-generation \
    opencv \
    roscpp \
    roslint \
    sensor-msgs \
    std-msgs \
    std-srvs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${PYTHON_PN}-psutil \
    ${PYTHON_PN}-pyserial \
    ${ROS_UNRESOLVED_PLATFORM_PKG_dnsmasq} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_gdal-bin} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_hostapd} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libnl-3} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_mapnik-utils} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_osm2pgsql} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_postgresql-postgis} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_python-cherrypy} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_python-colorama} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_python-mapnik} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_python-tilestache} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_unzip} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_wget} \
    curl \
    geometry-msgs \
    mavlink \
    message-runtime \
    rosbash \
    rosbridge-suite \
    roslaunch \
    rospy \
    sensor-msgs \
    std-msgs \
    std-srvs \
    vision-opencv \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${PYTHON_PN}-psutil \
    ${PYTHON_PN}-pyserial \
    ${ROS_UNRESOLVED_PLATFORM_PKG_dnsmasq} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_gdal-bin} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_hostapd} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libnl-3} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_mapnik-utils} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_osm2pgsql} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_postgresql-postgis} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_python-cherrypy} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_python-colorama} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_python-mapnik} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_python-tilestache} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_unzip} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_wget} \
    curl \
    geometry-msgs \
    mavlink \
    message-runtime \
    rosbash \
    rosbridge-suite \
    roslaunch \
    rospy \
    sensor-msgs \
    std-msgs \
    std-srvs \
    vision-opencv \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/rospilot/rospilot-release/archive/release/melodic/rospilot/1.5.6-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/rospilot"
SRC_URI = "git://github.com/rospilot/rospilot-release;${ROS_BRANCH};protocol=https"
SRCREV = "f2d7c6ed294131b0ab72c8537517418d5127d5f9"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
