# Metadata common to all ROS component types.
#
# Copyright (c) 2019 LG Electronics, Inc.

export ROS_DISTRO
export ROS_VERSION
export ROS_PYTHON_VERSION

# Ensure that PYTHON_PN is always set -- it's used to form dependency names. NB. ROS_PYTHON_VERSION is set
# in generated-ros-distro.inc, ie, it will never be unset when we get here.
PYTHON_PN ??= "${@'python3' if d.getVar('ROS_PYTHON_VERSION', True) == '3' else 'python'}"

inherit faulty-solibs
FILES_${PN}_prepend = " \
    ${datadir}/${ROS_BPN} \
    ${libdir}/${PYTHON_DIR} \
    ${libdir}/${ROS_BPN} \
"

FILES_${PN}-dev_prepend = " \
    ${datadir}/${ROS_BPN}/cmake \
"
