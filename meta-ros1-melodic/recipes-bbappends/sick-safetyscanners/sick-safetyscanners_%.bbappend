# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[sick-safetyscanners] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], 'Requires rqt-reconfigure which depends on python-qt-binding which requires meta-qt5 to be included and rqt-reconfigure->rqt-gui-py->qt-gui->python-pyqt5 which requires pyqt5', '', d)}"
