# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[rqt-multiplot] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], 'Requires qtbase which requires meta-qt5 to be included and rqt-gui-cpp->qt-gui->python-pyqt5 which requires pyqt5', '', d)}"
