# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[robot-body-filter] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['opengl', 'x11'], 'Depends on moveit-ros-perception->mesa which is not available because of missing opengl or vulkan in DISTRO_FEATURES and moveit-ros-perception->freeglut which requires x11', '', d)}"
