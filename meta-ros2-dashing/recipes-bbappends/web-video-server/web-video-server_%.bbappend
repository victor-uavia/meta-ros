# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[web-video-server] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ffmpeg', 'ffmpeg: Depends on ffmpeg which requires commercial license', '', d)}"
