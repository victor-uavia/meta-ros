# Copyright (c) 2019-2020 LG Electronics, Inc.

DESCRIPTION = "All non-test packages for the target from files/crystal/cache.yaml"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_melodic

PACKAGES = "${PN}"

RDEPENDS_${PN} = "${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES}"

# Requires Python 3; it is not used by any other ROS 1 package.
RDEPENDS_${PN}_remove = "catkin-virtualenv"
# Depends on blacklisted catkin-virtualenv
RDEPENDS_${PN}_remove = "haros-catkin"

# It is a fork of https://github.com/google/flatbuffers that's not used by any other ROS 1 package.
RDEPENDS_${PN}_remove = "flatbuffers"

# It is a "catkin-ized" edition of the upstream version that is not used by any other ROS 1 package.
RDEPENDS_${PN}_remove = "grpc"

# It has a dependency on rosparam_handler for which there isn't an entry in melodic-cache.yaml nor base.yaml nor python.yaml nor ruby.yaml; it is not used by any other ROS 1 package.
RDEPENDS_${PN}_remove = "iirob-filters"

# It is a "catkin-ized" edition of the upstream version that is not used by any other ROS 1 package.
RDEPENDS_${PN}_remove = "nanomsg"

# It has dependencies on Qt4 packages; it is not used by any other ROS 1 package.
RDEPENDS_${PN}_remove = "octovis"

# Generation of ROS package documentation will never be done on the target.
RDEPENDS_${PN}_remove = "rosdoc-lite"
# Depends on blacklisted rosdoc-lite
RDEPENDS_${PN}_remove = "jackal-tutorials"
RDEPENDS_${PN}_remove = "odom-frame-publisher"

# Fetches depot_tools during do_configure and then tries to use vpython which isn't in dependencies
RDEPENDS_${PN}_remove = "webrtc"
RDEPENDS_${PN}_remove = "webrtc-ros"

# Not compatible with newer libftdi included in meta-oe: https://github.com/kobuki-base/kobuki_ftdi/issues/3
RDEPENDS_${PN}_remove = "kobuki-ftdi"

# ERROR: Nothing PROVIDES 'UNRESOLVED-python-requests-oauthlib' (but generated-recipes/jsk-3rdparty/rostwitter_2.1.13-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "rostwitter"

# ERROR: Nothing PROVIDES 'UNRESOLVED-python-mechanize' (but generated-recipes/wifi-ddwrt/wifi-ddwrt_0.2.0.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "wifi-ddwrt"

# ERROR: Nothing PROVIDES 'UNRESOLVED-python-docker' (but generated-recipes/dockeros/dockeros_1.1.0-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "dockeros"

# ERROR: Nothing PROVIDES 'python-twisted-core' (but generated-recipes/linux-networking/multi-interface-roam_1.0.16-1.bb DEPENDS on or otherwise requires it). Close matches:
RDEPENDS_${PN}_remove = "multi-interface-roam"
RDEPENDS_${PN}_remove = "linux-networking"

# ERROR: Nothing PROVIDES 'UNRESOLVED-python-omniorb' (but generated-recipes/rtctree/rtctree_3.0.1.bb, generated-recipes/rtsprofile/rtsprofile_2.0.0-1.bb, generated-recipes/rtshell/rtshell_3.0.1-2.bb, generated-recipes/openrtm-aist-python/openrtm-aist-python_1.1.0.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "rtctree"
RDEPENDS_${PN}_remove = "rtsprofile"
RDEPENDS_${PN}_remove = "rtshell"
RDEPENDS_${PN}_remove = "openrtm-aist-python"

# ERROR: Nothing PROVIDES 'UNRESOLVED-python-libpgm-pip' (but generated-recipes/jsk-3rdparty/pgm-learner_2.1.13-1.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-python-scipy' (but generated-recipes/jsk-3rdparty/pgm-learner_2.1.13-1.bb, generated-recipes/husky/husky-bringup_0.4.2-1.bb, generated-recipes/calibration/calibration-estimation_0.10.14.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "pgm-learner"

# ERROR: Nothing PROVIDES 'UNRESOLVED-python-scipy' (but generated-recipes/jsk-3rdparty/pgm-learner_2.1.13-1.bb, generated-recipes/husky/husky-bringup_0.4.2-1.bb, generated-recipes/calibration/calibration-estimation_0.10.14.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "calibration-estimation"
RDEPENDS_${PN}_remove = "calibration"
RDEPENDS_${PN}_remove = "husky-bringup"
# ERROR: Nothing PROVIDES 'husky-bringup' (but generated-recipes/husky/husky-robot_0.4.2-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "husky-robot"

# ERROR: Nothing PROVIDES 'UNRESOLVED-python-pyassimp' (but generated-recipes/moveit-python/moveit-python_0.3.3-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'pyassimp', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYASSIMP}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYASSIMP = " \
    exotica \
    exotica-core-task-maps \
    exotica-examples \
    exotica-ompl-solver \
    exotica-python \
    fetch-bringup \
    fetch-moveit-config \
    fetch-ros \
    moveit-commander \
    moveit-python \
    pilz-industrial-motion \
    pilz-robot-programming \
    simple-grasping \
"

# recipes depending on various unavailable python modules
# ERROR: Nothing PROVIDES 'UNRESOLVED-python-cairosvg' (but generated-recipes/fiducials/aruco-detect_0.11.0-1.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-python-joblib' (but generated-recipes/fiducials/aruco-detect_0.11.0-1.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-python-urlgrabber' (but generated-recipes/jsk-visualization/jsk-rqt-plugins_2.1.5.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-python-sklearn' (but generated-recipes/jsk-visualization/jsk-rqt-plugins_2.1.5.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-python-cairo' (but generated-recipes/rqt-bag/rqt-bag-plugins_0.4.12.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-python-opengl' (but generated-recipes/rqt-pose-view/rqt-pose-view_0.5.8.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing RPROVIDES 'UNRESOLVED-python-termcolor' (but generated-recipes/criutils/criutils_0.1.3-2.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-deps', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_DEPS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON_DEPS = " \
    aruco-detect \
    criutils \
    desktop \
    fiducials \
    handeye \
    jsk-rqt-plugins \
    rqt-bag-plugins \
    rqt-common-plugins \
    rqt-pose-view \
    rqt-py-trees \
    rqt-robot-plugins \
    viz \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'vtk-qt', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_VTK_QT}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_VTK_QT = " \
    lvr2 \
    rc-cloud-accumulator \
    rtabmap \
    rtabmap-ros \
    simple-grasping \
"

# ERROR: Nothing PROVIDES 'UNRESOLVED-python-pyusb-pip' (but generated-recipes/jsk-3rdparty/respeaker-ros_2.1.13-1.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-python-speechrecognition-pip' (but generated-recipes/jsk-3rdparty/respeaker-ros_2.1.13-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "respeaker-ros"

# ERROR: Nothing PROVIDES 'UNRESOLVED-python-catkin-tools' (but generated-recipes/jsk-3rdparty/collada-urdf-jsk-patch_2.1.13-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "collada-urdf-jsk-patch"

# ERROR: Nothing PROVIDES 'UNRESOLVED-python-avahi' (but generated-recipes/multimaster-fkie/master-discovery-fkie_0.8.12.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "master-discovery-fkie"
# ERROR: Nothing PROVIDES 'master-discovery-fkie' (but generated-recipes/multimaster-fkie/master-sync-fkie_0.8.12.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing RPROVIDES 'master-discovery-fkie' (but generated-recipes/multimaster-fkie/master-sync-fkie_0.8.12.bb, generated-recipes/cpr-multimaster-tools/multimaster-launch_0.0.2-1.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "master-sync-fkie"
RDEPENDS_${PN}_remove = "node-manager-fkie"
RDEPENDS_${PN}_remove = "multimaster-fkie"
# ERROR: Nothing RPROVIDES 'master-discovery-fkie' (but generated-recipes/multimaster-fkie/master-sync-fkie_0.8.12.bb, generated-recipes/cpr-multimaster-tools/multimaster-launch_0.0.2-1.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "multimaster-launch"
# ERROR: Nothing PROVIDES 'multimaster-launch' (but generated-recipes/husky/husky-control_0.4.2-1.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing RPROVIDES 'multimaster-launch' (but generated-recipes/husky/husky-control_0.4.2-1.bb, generated-recipes/cpr-multimaster-tools/cpr-multimaster-tools_0.0.2-1.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "husky-control"
# ERROR: Nothing RPROVIDES 'multimaster-launch' (but generated-recipes/husky/husky-control_0.4.2-1.bb, generated-recipes/cpr-multimaster-tools/cpr-multimaster-tools_0.0.2-1.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "cpr-multimaster-tools"
# ERROR: Nothing PROVIDES 'husky-control' (but generated-recipes/husky/husky-base_0.4.2-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "husky-base"

# ERROR: Nothing PROVIDES 'UNRESOLVED-python-cwiid' (but generated-recipes/joystick-drivers/wiimote_1.13.0-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "wiimote"
# ERROR: Nothing RPROVIDES 'wiimote' (but generated-recipes/joystick-drivers/joystick-drivers_1.13.0-1.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "joystick-drivers"

# ERROR: Nothing PROVIDES 'UNRESOLVED-libopenvdb' (but generated-recipes/spatio-temporal-voxel-layer/spatio-temporal-voxel-layer_1.3.5-2.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-libopenexr-dev' (but generated-recipes/spatio-temporal-voxel-layer/spatio-temporal-voxel-layer_1.3.5-2.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-libopenvdb-dev' (but generated-recipes/spatio-temporal-voxel-layer/spatio-temporal-voxel-layer_1.3.5-2.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "spatio-temporal-voxel-layer"

# ERROR: Nothing PROVIDES 'UNRESOLVED-gfortran' (but generated-recipes/optpp-catkin/optpp-catkin_2.4.0-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "optpp-catkin"

# ERROR: Nothing PROVIDES 'UNRESOLVED-libopenni-dev' (but generated-recipes/openni-camera/openni-camera_1.11.1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "openni-camera"
RDEPENDS_${PN}_remove = "openni-launch"

# ERROR: Nothing PROVIDES 'UNRESOLVED-gforth' (but generated-recipes/wge100-driver/wge100-camera-firmware_1.8.2-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "wge100-camera-firmware"

# ERROR: Nothing PROVIDES 'UNRESOLVED-arduino-core' (but generated-recipes/rosserial/rosserial-arduino_0.8.0.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "rosserial-arduino"

# ERROR: Nothing PROVIDES 'UNRESOLVED-coinor-libipopt-dev' (but generated-recipes/ifopt/ifopt_2.0.7-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "ifopt"
RDEPENDS_${PN}_remove = "towr-ros"

# ERROR: Nothing PROVIDES 'UNRESOLVED-npm-native' (but generated-recipes/vapor-master/vapor-master_0.3.0.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "vapor-master"

# ERROR: Nothing PROVIDES 'UNRESOLVED-libopenscenegraph' (but generated-recipes/visualization-osg/osg-utils_1.0.2-2.bb, generated-recipes/visualization-osg/osg-interactive-markers_1.0.2-2.bb, generated-recipes/visualization-osg/osg-markers_1.0.2-2.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'osg', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OSG}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OSG = " \
    osg-interactive-markers \
    osg-markers \
    osg-utils \
    uwsim \
    uwsim-osgbullet \
    uwsim-osgocean \
    uwsim-osgworks \
"

# ERROR: Nothing PROVIDES 'UNRESOLVED-muparser' (but generated-recipes/ros-canopen/canopen-motor-node_0.8.2-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "canopen-motor-node"
RDEPENDS_${PN}_remove = "pilz-robots"
RDEPENDS_${PN}_remove = "prbt-pg70-support"
RDEPENDS_${PN}_remove = "prbt-grippers"

# ERROR: Nothing PROVIDES 'UNRESOLVED-java' (but generated-recipes/nao-meshes/nao-meshes_0.1.12-2.bb, generated-recipes/pepper-meshes/pepper-meshes_0.2.4-3.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "nao-meshes"
RDEPENDS_${PN}_remove = "pepper-meshes"

# ERROR: Nothing PROVIDES 'clang-tidy' (but generated-recipes/pilz-robots/pilz-utils_0.5.13-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "pilz-utils"
RDEPENDS_${PN}_remove = "prbt-moveit-config"

# ERROR: Nothing PROVIDES 'UNRESOLVED-libopenni2-dev' (but generated-recipes/openni2-camera/openni2-camera_0.4.2.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "openni2-camera"
RDEPENDS_${PN}_remove = "openni2-launch"

# ERROR: Nothing PROVIDES 'UNRESOLVED-libspnav-dev' (but generated-recipes/joystick-drivers/spacenav-node_1.13.0-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "spacenav-node"

# ERROR: Nothing PROVIDES 'UNRESOLVED-omniorb' (but generated-recipes/openrtm-aist/openrtm-aist_1.1.2-3.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "openrtm-aist"

# ERROR: Nothing PROVIDES 'ifopt' (but generated-recipes/towr/towr_1.4.1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "towr"

# ERROR: Nothing PROVIDES 'pilz-utils' (but generated-recipes/pilz-robots/prbt-hardware-support_0.5.13-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "prbt-hardware-support"

# ERROR: Nothing PROVIDES 'osg-markers' (but generated-recipes/visualization-osg/visualization-osg_1.0.2-2.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'osg-utils' (but generated-recipes/visualization-osg/visualization-osg_1.0.2-2.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'osg-interactive-markers' (but generated-recipes/visualization-osg/visualization-osg_1.0.2-2.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "visualization-osg"

# ERROR: Nothing PROVIDES 'wge100-camera-firmware' (but generated-recipes/wge100-driver/wge100-driver_1.8.2-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "wge100-driver"

# ERROR: Nothing RPROVIDES 'canopen-motor-node' (but generated-recipes/pilz-robots/prbt-support_0.5.13-1.bb, generated-recipes/ros-canopen/ros-canopen_0.8.2-1.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "prbt-support"
RDEPENDS_${PN}_remove = "ros-canopen"

# ERROR: Nothing RPROVIDES 'UNRESOLVED-python-tk' (but generated-recipes/cob-driver/cob-voltage-control_0.7.1-1.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "cob-voltage-control"

# ERROR: Nothing RPROVIDES 'UNRESOLVED-python-pandas' (but generated-recipes/rosbag-pandas/rosbag-pandas_0.5.3.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "rosbag-pandas"

# ERROR: Nothing RPROVIDES 'UNRESOLVED-python-scipy' (but generated-recipes/uuv-simulator/uuv-trajectory-control_0.6.13.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "uuv-trajectory-control"

# ERROR: Nothing RPROVIDES 'UNRESOLVED-python-termcolor' (but generated-recipes/py-trees-ros/py-trees-ros_0.5.18.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "py-trees-ros"

# ERROR: Nothing RPROVIDES 'UNRESOLVED-python-msgpack' (but generated-recipes/json-transport/json-transport_0.0.3.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "json-transport"

# ERROR: Nothing RPROVIDES 'UNRESOLVED-python-catkin-lint' (but generated-recipes/fetch-tools/fetch-tools_0.2.1.bb RDEPENDS on or otherwise requires it)
# ERROR: Nothing RPROVIDES 'UNRESOLVED-python-argcomplete' (but generated-recipes/fetch-tools/fetch-tools_0.2.1.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "fetch-tools"

# ERROR: Nothing RPROVIDES 'uuv-trajectory-control' (but generated-recipes/eca-a9/eca-a9-control_0.1.6.bb, generated-recipes/uuv-simulator/uuv-control-utils_0.6.13.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "eca-a9-control"
RDEPENDS_${PN}_remove = "uuv-control-utils"

# ERROR: Nothing RPROVIDES 'UNRESOLVED-network-manager' (but generated-recipes/network-autoconfig/network-autoconfig_0.1.1-2.bb RDEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "network-autoconfig"

# ERROR: Nothing PROVIDES 'UNRESOLVED-libnlopt-dev' (but generated-recipes/trac-ik/trac-ik-lib_1.5.1-1.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'UNRESOLVED-libnlopt0' (but generated-recipes/trac-ik/trac-ik-lib_1.5.1-1.bb DEPENDS on or otherwise requires it)
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'trac-ik', 'trac-ik trac-ik-examples trac-ik-kinematics-plugin trac-ik-lib trac-ik-python', '', d)}"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ogre', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OGRE}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OGRE = " \
    abb \
    abb-irb2400-moveit-config \
    abb-irb6640-moveit-config \
    franka-example-controllers \
    franka-ros \
    moveit \   
    moveit-ros \
    moveit-ros-visualization \
    moveit-setup-assistant \
    moveit-visual-tools \
    open-manipulator \
    open-manipulator-moveit \
    open-manipulator-with-tb3 \
    open-manipulator-with-tb3-waffle-moveit \
    open-manipulator-with-tb3-waffle-pi-moveit \
    panda-moveit-config \
    rviz-visual-tools \
    seed-r7-bringup \
    seed-r7-moveit-config \   
    seed-r7-typef-moveit-config \
    vision-visp \
    visp \
    visp-auto-tracker \
    visp-bridge \
    visp-camera-calibration \
    visp-hand2eye-calibration \
    visp-tracker \
"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT5}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT5 = " \
    adi-driver \
    agni-tf-tools \
    ainstein-radar \
    ainstein-radar-rviz-plugins \
    asmach-tutorials \
    cartographer-rviz \
    cis-camera \
    cob-command-tools \
    cob-dashboard \
    cob-manipulation \
    common-tutorials \
    dataspeed-pds-rqt \
    desktop \
    desktop-full \
    distance-map \
    distance-map-rviz \
    dynamixel-workbench \
    dynamixel-workbench-single-manager-gui \
    fetch-gazebo-demo \
    fetch-simulation \
    find-object-2d \
    fkie-potree-rviz-plugin \
    fmi-adapter-examples \
    franka-example-controllers \
    franka-ros \
    fsrobo-r \
    fsrobo-r-bringup \
    fsrobo-r-moveit-config \
    geometry-tutorials \
    gl-dependency \
    grid-map \
    grid-map-demos \
    grid-map-rviz-plugin \
    gundam-robot \
    gundam-rx78-control \
    husky-desktop \
    husky-viz \
    imagesift \
    imu-tools \
    jackal-desktop \
    jackal-viz \
    jsk-common \
    jsk-data \
    jsk-interactive \
    jsk-interactive-marker \
    jsk-interactive-test \
    jsk-pcl-ros \
    jsk-pcl-ros-utils \
    jsk-perception \
    jsk-recognition \
    jsk-recognition-utils \
    jsk-rqt-plugins \
    jsk-rviz-plugins \
    jsk-tools \
    jsk-visualization \
    kvh-geo-fog-3d \
    kvh-geo-fog-3d-rviz \
    libqt-concurrent \
    libqt-core \
    libqt-gui \
    libqt-opengl \
    libqt-opengl-rosdev \
    libqt-rosdev \
    libqt-svg-rosdev \
    libqt-network \
    libqt-widgets \
    librviz-tutorial \
    linux-networking \
    lvr2 \
    mapviz \
    mapviz-plugins \
    mir-gazebo \
    mir-robot \
    moveit \
    moveit-ros \
    moveit-ros-visualization \
    moveit-setup-assistant \
    mrpt-bridge \
    multi-map-server \
    multimaster-fkie \
    multires-image \
    neonavigation \
    neonavigation-launch \
    neonavigation-rviz-plugins \
    node-manager-fkie \
    octomap-rviz-plugins \
    open-manipulator \
    open-manipulator-control-gui \
    open-manipulator-with-tb3 \
    panda-moveit-config \
    pilz-robots \
    plotjuggler \
    pr2eus-tutorials \
    prbt-gazebo \
    prbt-grippers \
    prbt-moveit-config \
    prbt-pg70-support \
    python-qt-binding \
    qt-dotgraph \
    qt-gui \
    qt-gui-app \
    qt-gui-core \
    qt-gui-cpp \
    qt-gui-py-common \
    qt-qmake \
    rc-cloud-accumulator \
    ridgeback-desktop \
    ridgeback-viz \
    ros-controllers \
    ros-tutorials \
    rosbag-editor \
    rosmon \
    rqt \
    rqt-action \
    rqt-bag \
    rqt-bag-plugins \
    rqt-common-plugins \
    rqt-console \
    rqt-controller-manager \
    rqt-dep \
    rqt-drone-teleop \
    rqt-ez-publisher \
    rqt-graph \
    rqt-gui \
    rqt-gui-cpp \
    rqt-gui-py \
    rqt-image-view \
    rqt-joint-trajectory-controller \
    rqt-launch \
    rqt-launchtree \
    rqt-logger-level \
    rqt-moveit \
    rqt-msg \
    rqt-multiplot \
    rqt-nav-view \
    rqt-plot \
    rqt-pose-view \
    rqt-publisher \
    rqt-py-common \
    rqt-py-console \
    rqt-py-trees \
    rqt-reconfigure \
    rqt-robot-dashboard \
    rqt-robot-monitor \
    rqt-robot-plugins \
    rqt-robot-steering \
    rqt-rosmon \
    rqt-rotors \
    rqt-runtime-monitor \
    rqt-rviz \
    rqt-service-caller \
    rqt-shell \
    rqt-srv \
    rqt-tf-tree \
    rqt-top \
    rqt-topic \
    rqt-web \
    rtabmap-ros \
    rviz \
    rviz-imu-plugin \
    rviz-plugin-tutorials \
    rviz-python-tutorial \
    rviz-visual-tools \
    seed-r7-bringup \
    seed-r7-moveit-config \
    seed-r7-ros-pkg \
    seed-r7-samples \
    seed-r7-typef-moveit-config \
    sick-safetyscanners \
    simple-grasping \
    slam-toolbox \
    swri-console \
    swri-profiler-tools \
    tile-map \
    towr-ros \
    trajectory-tracker-rviz-plugins \
    turtle-actionlib \
    turtle-tf \
    turtle-tf2 \
    turtlesim \
    turtlesim-dash-tutorial \
    urdf-sim-tutorial \
    urdf-tutorial \
    visualization-tutorials \
    visualstates \
    viz \
    warthog-desktop \
    warthog-viz \
    webkit-dependency \
"

# OE won't let us build ffmpeg unless LICENSE_FLAGS_WHITELIST contains "commerical".
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ffmpeg', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FFMPEG}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FFMPEG = " \
    codec-image-transport \
    h264-encoder-core \
    h264-video-encoder \
    movie-publisher \
    mrpt1 \
    mrpt-bridge \
    mrpt-ekf-slam-2d \
    mrpt-ekf-slam-3d \
    mrpt-graphslam-2d \
    mrpt-icp-slam-2d \
    mrpt-local-obstacles \
    mrpt-localization \
    mrpt-map \
    mrpt-navigation \
    mrpt-rawlog \
    mrpt-rbpf-slam \
    mrpt-reactivenav2d \
    mrpt-slam \
    mvsim \
    parrot-arsdk \
    pose-cov-ops \
    rospilot \
    usb-cam \
    web-video-server \
"

# OE won't let us build gstreamer1.0-plugins-ugly unless LICENSE_FLAGS_WHITELIST contains "commerical".
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gst-ugly', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GSTREAMER1.0_PLUGINS_UGLY}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GSTREAMER1.0_PLUGINS_UGLY = " \
    audio-capture \
    audio-common \
    audio-play \
    cis-camera \
    imagesift \
    jsk-3rdparty \
    jsk-common \
    jsk-data \
    jsk-interactive \
    jsk-interactive-marker \
    jsk-interactive-test \
    jsk-pcl-ros-utils \
    jsk-pcl-ros \
    jsk-perception \
    jsk-pr2eus \
    jsk-recognition \
    jsk-recognition-utils \
    jsk-rviz-plugins \
    jsk-tools \
    jsk-topic-tools \
    jsk-visualization \
    julius-ros \
    multi-map-server \
    pr2eus \
    pr2eus-moveit \
    pr2eus-tutorials \
    resized-image-transport \
    ros-speech-recognition \
    sound-play \
    tts \
    voice-text \
"

# NB. gazebo-msgs is a dependency of non-Gazebo packages, so it doesn't appear here.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GAZEBO}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GAZEBO = " \
    ainstein-radar \
    ainstein-radar-gazebo-plugins \
    audibot \
    audibot-gazebo \
    blender-gazebo \
    cob-common \
    cob-description \
    cob-gazebo-objects \
    cob-gazebo-plugins \
    cob-gazebo-ros-control \
    cob-gazebo-worlds \
    cob-grasp-generation \
    cob-hardware-config \
    cob-manipulation \
    cob-moveit-bringup \
    desistek-saga-control \
    desistek-saga-description \
    desistek-saga-gazebo \
    desktop-full \
    drone-wrapper \
    eca-a9-description \
    eca-a9-gazebo \
    eusurdf \
    fetch-gazebo \
    fetch-gazebo-demo \
    fetch-simulation \
    fetchit-challenge \
    fsrobo-r \
    fsrobo-r-bringup \
    fsrobo-r-description \
    fsrobo-r-moveit-config \
    gazebo-plugins \
    gazebo-ros \
    gazebo-ros-control \
    gazebo-ros-pkgs \
    gazebo-rosdev \
    gundam-robot \
    gundam-rx78-gazebo \
    hector-gazebo \
    hector-gazebo-plugins \
    hector-gazebo-thermal-camera \
    hector-gazebo-worlds \
    hector-sensors-gazebo \
    husky-gazebo \
    husky-simulator \
    igvc-self-drive-description \
    igvc-self-drive-gazebo \
    igvc-self-drive-gazebo-plugins \
    igvc-self-drive-sim \
    jackal-gazebo \
    jackal-simulator \
    jderobot-assets \
    ksql-airport \
    lauv-control \
    lauv-description \
    lauv-gazebo \
    mcmillan-airfield \
    mecanum-gazebo-plugin \
    mir-description \
    mir-driver \
    mir-gazebo \
    mir-navigation \
    mir-robot \
    nmea-gps-plugin \
    open-manipulator-gazebo \
    open-manipulator-simulations \
    open-manipulator-with-tb3-gazebo \
    open-manipulator-with-tb3-simulations \
    pr2-controller-configuration-gazebo \
    pr2-gazebo \
    pr2-gazebo-plugins \
    pr2-simulator \
    prbt-gazebo \
    raw-description \
    rexrov2-control \
    rexrov2-description \
    rexrov2-gazebo \
    ridgeback-gazebo \
    ridgeback-gazebo-plugins \
    ridgeback-simulator \
    rotors-gazebo \
    rotors-gazebo-plugins \
    rotors-simulator \
    sand-island \
    simulators \
    turtlebot3-gazebo \
    turtlebot3-simulations \
    urdf-sim-tutorial \
    usv-gazebo-plugins \
    uuv-descriptions \
    uuv-gazebo-plugins \
    uuv-gazebo-ros-plugins \
    uuv-gazebo-worlds \
    uuv-sensor-ros-plugins \
    uuv-simulator \
    uuv-world-plugins \
    uuv-world-ros-plugins \
    velodyne-gazebo-plugins \
    velodyne-simulator \
    vrx-gazebo \
    wamv-gazebo \
    warthog-gazebo \
    warthog-simulator \
    wave-gazebo \
    wave-gazebo-plugins \
    yosemite-valley \
"

# Depends on libqt4-dev from https://git.yoctoproject.org/cgit/cgit.cgi/meta-qt4
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt4', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT4}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT4 = " \
    hector-geotiff \
    hector-geotiff-plugins \
    hector-slam \
    hector-slam-launch \
"

# Depends on vlc from meta-multimedia
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'multimedia', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_MULTIMEDIA}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_MULTIMEDIA = " \
    cob-android \
    cob-android-script-server \
    cob-command-gui \
    cob-command-tools \
    cob-default-robot-behavior \
    cob-driver \
    cob-helper-tools \
    cob-mimic \
    cob-monitoring \
    cob-moveit-interface \
    cob-script-server \
    cob-sound \
    cob-teleop \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'wxpython', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_WXPYTHON}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_WXPYTHON = " \
    executive-smach-visualization \
    seed-r7-ros-pkg \
    seed-r7-samples \
    smach-viewer \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lisp', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_LISP}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_LISP = " \
    actionlib-lisp \
    cl-tf \
    cl-tf2 \
    cl-transforms \
    cl-transforms-stamped \
    cl-urdf \
    cl-utils \
    eus-assimp \
    euslisp \
    geneus \
    genlisp \
    jskeus \
    jsk-model-tools \
    jsk-roseus \
    ros-emacs-utils \
    rosemacs \
    roseus \
    roseus-mongo \
    roseus-smach \
    roseus-tutorials \
    roslisp \
    roslisp-common \
    roslisp-repl \
    roslisp-utilities \
    slime-ros \
    slime-wrapper \
"

# Depends on mesa or libglu which requires opengl or vulkan DISTRO_FEATURE
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opengl', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL}', '', d)}"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL = " \
    abb \
    abb-irb2400-moveit-config \
    abb-irb6640-moveit-config \
    cob-collision-monitor \
    cob-obstacle-distance-moveit \
    cob-moveit-bringup \
    cob-moveit-interface \
    desktop-full \
    exotica \
    exotica-aico-solver \
    exotica-collision-scene-fcl \
    exotica-collision-scene-fcl-latest \
    exotica-core \
    exotica-core-task-maps \
    exotica-examples \
    exotica-ik-solver \
    exotica-levenberg-marquardt-solver \
    exotica-ompl-solver \
    exotica-python \
    exotica-time-indexed-rrt-connect-solver \
    fetch-bringup \
    fetch-moveit-config \
    fetch-ros \
    fsrobo-r-trajectory-filters \
    industrial-core \
    industrial-trajectory-filters \
    libg2o \
    moveit-commander \
    moveit-fake-controller-manager \
    moveit-planners \
    moveit-planners-ompl \
    moveit-plugins \
    moveit-pr2 \
    moveit-ros-benchmarks \
    moveit-ros-manipulation \
    moveit-ros-move-group \
    moveit-ros-perception \
    moveit-ros-planning \
    moveit-ros-planning-interface \
    moveit-ros-robot-interaction \
    moveit-ros-warehouse \
    moveit-runtime \
    moveit-sim-controller \
    moveit-visual-tools \
    navigation-stage \
    navigation-tutorials \
    open-manipulator-controller \
    open-manipulator-moveit \
    open-manipulator-with-tb3-tools \
    open-manipulator-with-tb3-waffle-moveit \
    open-manipulator-with-tb3-waffle-pi-moveit \
    pilz-industrial-motion \
    pilz-robot-programming \
    pilz-trajectory-generation \
    pr2-moveit-config \
    rc-visard \
    robot-body-filter \
    roomba-stage \
    rtabmap \
    rtabmap-ros \
    safe-teleop-stage \
    seed-r7-navigation \
    simulators \
    stage \
    stage-ros \
    teb-local-planner \
    teb-local-planner-tutorials \
    uwsim \
    uwsim-bullet \
    uwsim-osgbullet \
    uwsim-osgocean \
    uwsim-osgworks \
    wxwidgets \
    rc-roi-manager-gui \
    rqt-pose-view \
"
