# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[lvr2] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'vtk-qt'], 'Requires qtbase which requires meta-qt5 to be included and requires libvtk-qt which is not available', '', d)}"
