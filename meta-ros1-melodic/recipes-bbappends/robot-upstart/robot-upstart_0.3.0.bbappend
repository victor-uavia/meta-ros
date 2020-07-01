# Copyright (c) 2020 LG Electronics, Inc.

# ERROR: robot-upstart-0.3.0-r0 do_package_qa: QA Issue: /opt/ros/melodic/lib/robot_upstart/mkxacro contained in package robot-upstart requires /bin/bash, but no providers found in RDEPENDS_robot-upstart? [file-rdeps]
RDEPENDS_${PN} += "bash"

# This is needed only for webOS OSE and it's not in meta-ros-webos, because
# then meta-ros-webos would need to include this .bbappend just when
# meta-ros1-melodic layer is included
VIRTUAL-RUNTIME_bash ?= "bash"
RDEPENDS_${PN}_append_class-target_webos = " ${VIRTUAL-RUNTIME_bash}"
RDEPENDS_${PN}_remove_class-target_webos = "${@oe.utils.conditional('WEBOS_PREFERRED_PROVIDER_FOR_BASH', 'busybox', 'bash', '', d)}"
