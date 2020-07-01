# Copyright (c) 2019-2020 LG Electronics, Inc.

DESCRIPTION = "All non-test packages for the target from files/eloquent/cache.yaml"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_eloquent

PACKAGES = "${PN}"

RDEPENDS_${PN} = "${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES}"

# Contains only dev, dbg and staticdev files, so PN is empty and not created
RDEPENDS_${PN}_remove = "sophus"

# Contains only dev, dbg and staticdev files, so PN is empty and not created
RDEPENDS_${PN}_remove = "test-osrf-testing-tools-cpp"

# alternative not yet supported implementation for fastrtps
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CONNEXT}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CONNEXT = " \
    connext-cmake-module \
    rmw-connext-cpp \
    rmw-connext-shared-cpp \
    rosidl-typesupport-connext-c \
    rosidl-typesupport-connext-cpp \
"
# alternative not yet supported implementation for fastrtps
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opensplice', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENSPLICE}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENSPLICE = " \
    opensplice-cmake-module \
    rmw-opensplice-cpp \
    rosidl-typesupport-opensplice-c \
    rosidl-typesupport-opensplice-cpp \
"
# Can't build these until we figure out how to build clang-format, clang-tidy without building all of clang.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'clang', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CLANG}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CLANG = " \
    ament-clang-format \
    ament-clang-tidy \
    ament-cmake-clang-format \
    ament-cmake-clang-tidy \
"
# Depends on python3-docker which is available in meta-virtualization, but we don't want to add the
# dependency on this layer to meta-ros yet
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'docker', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_DOCKER}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_DOCKER = " \
    cross-compile \
"
# Needs work to launch qemu to run tests on image on build machine.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'launch', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LAUNCH}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LAUNCH = " \
    launch-testing-ament-cmake \
"
# | CMake Error at .../cartographer/1.0.0-1-r0/recipe-sysroot/usr/lib/cmake/Ceres/CeresConfig.cmake:88 (message):
# |   Failed to find Ceres - Missing requested Ceres components: [SuiteSparse]
# |   (components requested: [SuiteSparse]).  Detected Ceres version: 1.14.0
# |   installed in:
# |   .../cartographer/1.0.0-1-r0/recipe-sysroot/usr
# |   with components: [EigenSparse, SparseLinearAlgebraLibrary,
# |   SchurSpecializations, OpenMP, Multithreading].
# Also depends on python2 python-sphinx which isn't available in ROS2 which is python3-only
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'cartographer', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CARTOGRAPHER}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CARTOGRAPHER = " \
    cartographer \
    cartographer-ros \
"
# recipes depending on python3-matplotlib
# there is python2 version in meta-ros-common/recipes-devtools/python/python-matplotlib_2.1.1.bb
# but no python3 version yet
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python3-matplotlib', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON3_MATPLOTLIB}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON3_MATPLOTLIB = " \
    desktop \
    rqt-common-plugins \
    rqt-plot \
"
# Depends on coin-or libcbc for which we don't have recipes yet
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'coin-or', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_COIN_OR}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_COIN_OR = " \
    plansys2-executor \
    plansys2-multidomain-example \
    plansys2-patrol-navigation-example \
    plansys2-simple-example \
    plansys2-terminal \
    popf \
"
# Not compatible with newer libftdi included in meta-oe: https://github.com/kobuki-base/kobuki_ftdi/issues/3
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'kobuki-ftdi', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_KOBUKI_FTDI}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_KOBUKI_FTDI = " \
    kobuki-ftdi \
"
# recipes depending on openvdb and openexr for which we don't have recipes yet
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'openvdb-openexr', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENVDB_OPENEXR}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENVDB_OPENEXR = " \
    spatio-temporal-voxel-layer \
"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'pyqt5', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYQT5}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYQT5 = " \
    py-trees-js \
    py-trees-ros-tutorials \
    py-trees-ros-viewer \
    python-qt-binding \
    qt-dotgraph \
    qt-gui \
    qt-gui-app \
    qt-gui-core \
    qt-gui-cpp \
    qt-gui-py-common \
    rqt \
    rqt-action \
    rqt-console \
    rqt-graph \
    rqt-gui \
    rqt-gui-cpp \
    rqt-gui-py \
    rqt-image-view \
    rqt-msg \
    rqt-publisher \
    rqt-py-common \
    rqt-py-console \
    rqt-reconfigure \
    rqt-robot-steering \
    rqt-service-caller \
    rqt-shell \
    rqt-srv \
    rqt-tf-tree \
    rqt-top \
    rqt-topic \
"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'x11', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X11}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X11 = " \
    nav2-rviz-plugins \
    rviz-common \
    rviz-default-plugins \
    rviz-ogre-vendor \
    rviz-rendering \
"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT5}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT5 = " \
    desktop \
    nav2-rviz-plugins \
    py-trees-js \
    py-trees-ros-tutorials \
    py-trees-ros-viewer \
    python-qt-binding \
    qt-dotgraph \
    qt-gui \
    qt-gui-app \
    qt-gui-core \
    qt-gui-cpp \
    qt-gui-py-common \
    rqt \
    rqt-action \
    rqt-common-plugins \
    rqt-console \
    rqt-graph \
    rqt-gui \
    rqt-gui-cpp \
    rqt-gui-py \
    rqt-image-view \
    rqt-msg \
    rqt-plot \
    rqt-publisher \
    rqt-py-common \
    rqt-py-console \
    rqt-reconfigure \
    rqt-robot-steering \
    rqt-service-caller \
    rqt-shell \
    rqt-srv \
    rqt-tf-tree \
    rqt-top \
    rqt-topic \
    rviz-common \
    rviz-default-plugins \
    rviz-rendering \
    turtlesim \
"
# NB. gazebo-msgs is a dependency of non-Gazebo packages, so it doesn't appear here.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GAZEBO}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GAZEBO = " \
    dolly \
    dolly-gazebo \
    gazebo-plugins \
    gazebo-ros \
    gazebo-ros-pkgs \
    gazebo-rosdev \
    nav2-system-tests \
"
# Depends on libqt4-dev from https://git.yoctoproject.org/cgit/cgit.cgi/meta-qt4
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt4', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT4}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT4 = " \
    octovis \
"
# Depends on mesa or libglu which requires opengl or vulkan DISTRO_FEATURE
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opengl', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL = " \
    rviz-ogre-vendor \
"
