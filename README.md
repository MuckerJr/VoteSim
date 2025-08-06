# Voting Simulation Engine

This project is a simulation of voting behaviour and electoral systems, written in **Java** and is still a **work in progress**

## Why I Built This

I started this project to teach myself Java through a concept I’m intrigued by: **electoral reform and political behaviour**. My goal has been to simulate voting patterns, tactical decisions, and the impact of different voting systems in a flexible, extensible way.

Although I’ve had support from ChatGPT in explaining new Java concepts and debugging logical errors, I’ve made a point of implementing the core structural logic myself, writing from scratch wherever possible. This was important to ensure I *understood* the algorithms and structure, not just pasted code. Trying to avoid “vibe coding”, I’ve attempted to keep myself honest and focused on the fundamentals.

## Project Highlights

- **Voter generation** based on real-world political spectrum data.
- **Multiple political parties** with different leanings and appeal, and will be introducing the ability to add more.
- A flexible **voting engine** that can support tactical voting, proportional representation, and other electoral mechanics.
- Room to scale into more complex behaviour, including:
  - Numeric political alignment (-100 to 100) for parties and voters.
  - Event-driven shifts in public opinion.
  - Tactical vote splitting and coalition-building.

## Data Sources

To keep the simulation grounded, I’ve used real UK political data and analysis from:
- [YouGov](https://yougov.co.uk/)
- [Electoral Reform Society](https://www.electoral-reform.org.uk/)

## Future Plans

This project has rapidly grown in complexity and I’ve thoroughly enjoyed trying to keep up. Some of the next things I’d like to explore:
- Better UI (starting with a CLI interface, possibly evolving to a web-based dashboard)
- Multi-dimensional political spectrums (e.g. social vs economic)
- User generated parties and statistics to try and model elections under different electoral situations
- Consecutive Elections that depend on data from previous results

## Tech Stack (so far)

- Java 17+
- JUnit for testing (planned)

## Contact

If you're an employer or dev interested in simulations, political modelling, or Java code structure, feel free to reach out via GitHub.
