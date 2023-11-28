use assets::AppAssets;
use bevy::{
    diagnostic::{FrameTimeDiagnosticsPlugin, LogDiagnosticsPlugin},
    prelude::*,
    window::PresentMode,
};
use bevy_asset_loader::prelude::*;
use bevy_common_assets::json::JsonAssetPlugin;
use bevy_inspector_egui::quick::WorldInspectorPlugin;
use game::GamePlugin;
use localization::Localization;
use menu::MenuPlugin;
use settings::init_settings;
use startup_systems::spawn_2d_camera;

mod animation;
mod assets;
mod constants;
mod game;
mod localization;
mod menu;
mod settings;
mod startup_systems;
mod style;

fn main() {
    App::new()
        .add_plugins((
            DefaultPlugins.set(WindowPlugin {
                primary_window: Some(Window {
                    title: "Maxon Petting Simulator".into(),
                    present_mode: PresentMode::AutoVsync,
                    ..default()
                }),
                ..default()
            }),
            JsonAssetPlugin::<Localization>::new(&["locale.json"]),
        ))
        // App states
        .add_state::<AppState>()
        // Initializing startup systems
        .add_systems(Startup, (spawn_2d_camera, init_settings))
        // Loading state
        .add_loading_state(LoadingState::new(AppState::Boot).continue_to_state(AppState::Menu))
        .add_collection_to_loading_state::<_, AppAssets>(AppState::Boot)
        .add_plugins((GamePlugin, MenuPlugin))
        // Diagnostics
        .add_plugins((LogDiagnosticsPlugin::default(), FrameTimeDiagnosticsPlugin))
        // World inspector
        .add_plugins(WorldInspectorPlugin::new())
        .run();
}

#[derive(Clone, Eq, PartialEq, Debug, Hash, Default, States)]
pub enum AppState {
    #[default]
    Boot,
    Menu,
    Game,
    Pause,
}