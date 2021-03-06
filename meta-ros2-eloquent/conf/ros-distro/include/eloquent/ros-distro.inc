# eloquent/ros-distro.inc
# General configuration settings that are dependent on ROS_DISTRO.
#
# Copyright (c) 2019 LG Electronics, Inc.

ROS_DISTRO_CODENAME = "Eloquent Elusor"

# The platform release that the metadata for this ROS distro targets. This determines the versions of the platform packages that
# OE must provide. It must be one of the values of ROS_DISTRO_RELEASE_PLATFORMS (which is set in
# generated/superflore-ros-distro.inc).
ROS_DISTRO_BASELINE_PLATFORM = "ubuntu-bionic"

require conf/ros-distro/include/eloquent/generated/superflore-datetime.inc
require conf/ros-distro/include/eloquent/generated/superflore-ros-distro.inc
require conf/ros-distro/include/eloquent/ros-distro-recipe-blacklist.inc
require conf/ros-distro/include/eloquent/ros-distro-preferred-versions.inc
require conf/ros-distro/include/eloquent/ros-distro-preferred-providers.inc

# alternative not yet supported implementation for fastrtps
ROS_WORLD_SKIP_GROUPS += "connext"
# alternative not yet supported implementation for fastrtps
ROS_WORLD_SKIP_GROUPS += "opensplice"
# Can't build these until we figure out how to build clang-format, clang-tidy without building all of clang.
ROS_WORLD_SKIP_GROUPS += "clang"
# Depends on python3-docker which is available in meta-virtualization, but we don't want to add the
# dependency on this layer to meta-ros yet
ROS_WORLD_SKIP_GROUPS += "docker"
# Needs work to launch qemu to run tests on image on build machine.
ROS_WORLD_SKIP_GROUPS += "launch"
# recipes depending on turtlebot3 specific recipes which weren't ported to eloquent yet
ROS_WORLD_SKIP_GROUPS += "turtlebot3"
# recipes depending on ROS_UNRESOLVED_PLATFORM_PKG_python3-babeltrace which cannot be just
# set to babeltrace, because python bindings in babeltrace are not enabled as shown in log.do_configure:
# configure: You may configure with --enable-python-bindings if you want Python bindings.
ROS_WORLD_SKIP_GROUPS += "babeltrace-python"
# recipes depending on python3-matplotlib
# there is python2 version in meta-ros-common/recipes-devtools/python/python-matplotlib_2.1.1.bb
# but no python3 version yet
ROS_WORLD_SKIP_GROUPS += "python3-matplotlib"
# recipes depending on coin-or libcbc for which we don't have recipes yet
ROS_WORLD_SKIP_GROUPS += "coin-or"
# Not compatible with newer libftdi included in meta-oe: https://github.com/kobuki-base/kobuki_ftdi/issues/3
ROS_WORLD_SKIP_GROUPS += "kobuki-ftdi"
# recipes depending on openvdb and openexr for which we don't have recipes yet
ROS_WORLD_SKIP_GROUPS += "openvdb-openexr"
# recipes depending on gazebo, for which there is no OE recipe
ROS_WORLD_SKIP_GROUPS += "gazebo"

# recipes depending on something from meta-qt5 layer
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', '', 'qt5', d)}"
# recipes depending on something from meta-qt4 layer
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt4-layer', '', 'qt4', d)}"

# recipes depending on 'x11' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', '', 'x11', d)}"
# recipes depending on 'opengl' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '', 'opengl', d)}"

# recipes depending on python*-pyqt5 from meta-qt5 layer
# Use separate group, because e.g. webOS OSE has meta-qt5 layer included, but python*-pyqt5
# is blacklisted, because webOS OSE is missing newer meta-qt5 from warrior with older meta-oe thud which has
# incompatible old sip
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', '', 'pyqt5', d)}"

# Override settings from generated/superflore-ros-distro.inc here.

# Since superflore doesn't know when it's generating a recipe that it will be for a build tool, it can't know that what's in
# ROS_EXEC_DEPEND are also build tools. Manually add them here.
ROS_SUPERFLORE_GENERATED_BUILDTOOLS += " \
    ament-lint-native \
    foonathan-memory-vendor-native \
    domain-coordinator-native \
    poco-vendor-native \
    rcpputils-native \
    rcutils-native \
    rmw-native \
    rmw-fastrtps-cpp-native \
    rmw-fastrtps-dynamic-cpp-native \
    rmw-fastrtps-shared-cpp-native \
    rmw-implementation-cmake-native \
    rmw-implementation-native \
    rosidl-actions-native \
    rosidl-adapter-native \
    rosidl-typesupport-fastrtps-c-native \
    uncrustify-vendor-native \
"

ROS_UNRESOLVED_PLATFORM_PKG_python3-cryptography = "python3-cryptography"

ROS_UNRESOLVED_PLATFORM_PKG_python3-mypy = "python3-mypy"

ROS_UNRESOLVED_PLATFORM_PKG_python3-future = "python3-future"

# Used by:
# generated-recipes/ros2cli/ros2cli_0.8.7-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-netifaces = "python3-netifaces"

# Used by:
# generated-recipes/ros2cli/ros2doctor_0.8.7-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-ifcfg = "python3-ifcfg"

# Used by generated-recipes/geographic-info/geodesy_1.0.1-1.bb
# use python3 version because python2 is EOL
ROS_UNRESOLVED_PLATFORM_PKG_python-pyproj = "python3-pyproj"

# Used by generated-recipes/teleop-tools/mouse-teleop_1.0.1-1.bb
# use python3 version because python2 is EOL
ROS_UNRESOLVED_PLATFORM_PKG_python-tk = "python3-tkinter"

# python3 bindings are provided by lttng-tools when python PACKAGECONFIG is enabled there
ROS_UNRESOLVED_PLATFORM_PKG_python3-lttng = "lttng-tools"

ROS_UNRESOLVED_PLATFORM_PKG_spdlog = "spdlog"

# Used by generated-recipes/phidgets-drivers/libphidget22_2.0.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libusb-1.0 = "libusb1"

# Used by generated-recipes/spatio-temporal-voxel-layer/spatio-temporal-voxel-layer_2.1.2-2.bb
ROS_UNRESOLVED_PLATFORM_PKG_tbb = "tbb"

# Used by generated-recipes/navigation2/nav2-map-server_0.3.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_graphicsmagick = "graphicsmagick"

# Used by generated-recipes/kobuki-ftdi/kobuki-ftdi_1.0.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libusb-dev = "libusb1"
ROS_UNRESOLVED_PLATFORM_PKG_libftdi-dev = "libftdi"
ROS_UNRESOLVED_PLATFORM_PKG_ftdi-eeprom = "libftdi"

# Used by generated-recipes/popf/popf_0.0.11-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_flex = "flex"
ROS_UNRESOLVED_PLATFORM_PKG_bison = "bison"

# Used by generated-recipes/ament-virtualenv/ament-virtualenv_0.0.5-6.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-packaging = "python3-packaging"
ROS_UNRESOLVED_PLATFORM_PKG_python3-packaging-native = "python3-packaging-native"
ROS_UNRESOLVED_PLATFORM_PKG_python-virtualenv = "python3-virtualenv"
ROS_UNRESOLVED_PLATFORM_PKG_python-virtualenv-native = "python3-virtualenv-native"

# used by generated-recipes/navigation2/nav2-util_0.3.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-program-options = "boost"

# Used by:
# generated-recipes/py-trees-ros-tutorials/py-trees-ros-tutorials_2.0.1-1.bb
# generated-recipes/py-trees-js/py-trees-js_0.6.1-1.bb
# generated-recipes/py-trees-ros-viewer/py-trees-ros-viewer_0.2.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_pyqt5-dev-tools = "python3-pyqt5"

# Used by:
# generated-recipes/py-trees-ros-tutorials/py-trees-ros-tutorials_2.0.1-1.bb
# generated-recipes/py-trees-js/py-trees-js_0.6.1-1.bb
# generated-recipes/py-trees-ros-viewer/py-trees-ros-viewer_0.2.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_qttools5-dev-tools = "python3-pyqt5"

# Used by:
# generated-recipes/py-trees-ros-tutorials/py-trees-ros-tutorials_2.0.1-1.bb
# generated-recipes/py-trees-js/py-trees-js_0.6.1-1.bb
# generated-recipes/py-trees-ros-viewer/py-trees-ros-viewer_0.2.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-qt5-bindings = "python3-pyqt5"

# Used by:
# generated-recipes/py-trees-js/py-trees-js_0.6.1-1.bb
# generated-recipes/py-trees-ros-viewer/py-trees-ros-viewer_0.2.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-pyqt5.qtwebengine = "python3-pyqt5"

# tango-icon-theme isn't available, but adwaita-icon-theme should be compatible
# Used by:
# generated-recipes/qt-gui-core/qt-gui_1.0.7-1.bbb
ROS_UNRESOLVED_PLATFORM_PKG_tango-icon-theme = "adwaita-icon-theme"

# XXX Temp until superflore fixed.
# Must use a _pn- override in this file to override the ROS_BUILD_TYPE of a generated recipe,
# because we need to set this variable before the "inherit" line in the recipe is parsed,
# and having it in a .bbappend sets it too late.
ROS_BUILD_TYPE_pn-automotive-autonomy-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-automotive-navigation-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-automotive-platform-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-fmilibrary-vendor = "ament_cmake"
ROS_BUILD_TYPE_pn-geographic-info = "ament_cmake"
ROS_BUILD_TYPE_pn-ml-classifiers = "ament_cmake"
ROS_BUILD_TYPE_pn-ros-workspace = "ament_cmake"
ROS_BUILD_TYPE_pn-sros2-cmake = "ament_cmake"
