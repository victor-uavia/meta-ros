# Copyright (c) 2019 LG Electronics, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-parser-native \
"

# usr/share/builtin_interfaces/cmake/ament_cmake_export_dependencies-extras.cmake contains:
#
#     set(_exported_dependencies "rosidl_default_runtime")

ROS_EXPORT_DEPENDS += "rosidl-default-runtime"
