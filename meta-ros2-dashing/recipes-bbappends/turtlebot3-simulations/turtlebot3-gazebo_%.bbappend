# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[turtlebot3-gazebo] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'gazebo: depends on gazebo-ros-pkgs->gazebo-rosdev->gazebo which is not available', '', d)}"
