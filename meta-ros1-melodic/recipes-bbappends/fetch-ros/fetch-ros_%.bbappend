# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[fetch-ros] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyassimp'], 'Requires fetch-moveit-config which depends on moveit-ros-visualization which depends on qtbase which requires meta-qt5 to be included and rdepends on fetch-moveit-config which rdepends on moveit-python which depends on unavailable UNRESOLVED-python-pyassimp', '', d)}"
