help:
	@echo "Available Makefile commands:"
	@echo "  make build         - Build the project"
	@echo "  make build-plugin  - Build the IntelliJ plugin"
	@echo "  make verify-plugin - Verify plugin compatibility"
	@echo "  make test          - Run the tests"
	@echo "  make test-coverage - Run tests with coverage report"
	@echo "  make codecov       - Upload coverage report to Codecov"
	@echo "  make inspections   - Run Qodana code inspections"
	@echo "  make run           - Launch IntelliJ with the plugin for testing"

build:
	./gradlew build

build-plugin:
	./gradlew buildPlugin

verify-plugin:
	./gradlew verifyPlugin

test:
	./gradlew test

run:
	./gradlew runIde
