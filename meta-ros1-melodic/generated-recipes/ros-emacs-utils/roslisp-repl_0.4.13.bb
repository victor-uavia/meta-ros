# Generated by superflore -- DO NOT EDIT

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "This package provides a script that launches Emacs with Slime (the     Superior Lisp Interaction Mode) ready for Lisp development and     roslisp."
AUTHOR = "Gayane Kazhoyan <kazhoyan@cs.uni-bremen.de>"
ROS_AUTHOR = "Lorenz Moesenlechner"
HOMEPAGE = "https://github.com/code-iai/ros_emacs_utils"
SECTION = "devel"
LICENSE = "public_domain"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=90cf8e14bb501c1f6d3eda81e45e438a"

ROS_CN = "ros_emacs_utils"
ROS_BPN = "roslisp_repl"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_sbcl} \
    rosemacs \
    roslisp \
    slime-ros \
    slime-wrapper \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_sbcl} \
    rosemacs \
    roslisp \
    slime-ros \
    slime-wrapper \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/code-iai-release/ros_emacs_utils-release/archive/release/melodic/roslisp_repl/0.4.13-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/roslisp_repl"
SRC_URI = "git://github.com/code-iai-release/ros_emacs_utils-release;${ROS_BRANCH};protocol=https"
SRCREV = "78e2e95a9920b85faa0881ddab4fd58d5abe1a4c"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
