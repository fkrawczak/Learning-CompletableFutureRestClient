# CompletableFutureRestClient

App created for learning purposes.

This project explores asynchronous programming in Java using `CompletableFuture` combined with a REST client. It simulates calls to slow/delayed external services to practice non-blocking composition, chaining, and error handling with `CompletableFuture`.

To simulate long-running responses, the project uses [`ghcr.io/mccutchen/go-httpbin`](https://github.com/mccutchen/go-httpbin), a lightweight httpbin implementation run via Docker, which provides endpoints (e.g. `/delay/{n}`) that respond after a configurable delay.