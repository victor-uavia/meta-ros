# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[nav2-system-tests] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'gazebo: depends on gazebo-ros-pkgs->gazebo-ros->gazebo-rosdev->gazebo which is not available', '', d)}"
