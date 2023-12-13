resource "docker_image" "home_assistant" {
  name = "ghcr.io/home-assistant/home-assistant:stable"
}

resource "docker_container" "home_assistant" {
  name  = "home_assistant"
  image = docker_image.home_assistant.name

  restart = "unless-stopped"
  destroy_grace_seconds = 30
  must_run = true
  memory = 256

  volumes {
    host_path      = "/var/run/docker.sock"
    container_path = "/var/run/docker.sock"
  }

  command = [
    "--name homeassistant",
    "--privileged",
    "-e TZ=America/Chicago",
    "-v /homeassistant:/config",
    "-v /run/dbus:/run/dbus:ro",
    "--network=host"
  ]

}