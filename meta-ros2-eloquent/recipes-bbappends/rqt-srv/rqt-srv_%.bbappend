# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[rqt-srv] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], 'qt5: depends on rqt-msg->python-qt-bindings->qtbase; pyqt5: depends on rqt-msg->python-qt-binding->python3-pyqt5 which requires pyqt5', '', d)}"
