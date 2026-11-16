{
  description = "forge 1.8.9 dev env";

  inputs.nixpkgs.url = "github:NixOS/nixpkgs/nixos-26.05";

  outputs = { nixpkgs, ... }:
    let
      system = "x86_64-linux";

      pkgs = import nixpkgs {
        inherit system;
      };

      nativeLibraries = with pkgs; [
        libGL
        libGLU
        libx11
        libxext
        libxcursor
        libxrandr
        libxxf86vm
        libxi
        libxrender
        libxtst

        openal
        alsa-lib
        libpulseaudio
        libudev0-shim

        stdenv.cc.cc.lib
      ];
    in
    {
      devShells.${system}.default = pkgs.mkShellNoCC {
        packages = with pkgs; [
          jdk8
          git
          unzip
        ];

        JAVA_HOME = pkgs.jdk8.home;

        LD_LIBRARY_PATH =
          "/run/opengl-driver/lib:"
          + pkgs.lib.makeLibraryPath nativeLibraries;
      };
    };
}
