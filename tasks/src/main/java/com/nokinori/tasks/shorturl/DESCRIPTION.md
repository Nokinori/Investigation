# Livecodig in 45 minutes

## 1 - Shorten URL "SEO"

Given as input a URL and a SEO keyword with a max length of 20 characters, chosen by the user, generate a SEO URL.

Example:

Input:
URL: http://looooong.com/somepath
SEO keyword: MY-NEW-WS
Output:
URL: http://short.com/MY-NEW-WS

Input:
URL: http://looooong.com/somepath
SEO keyword: POTATO
Output:
URL: http://short.com/POTATO

## 2 - Random keyword generation

Given a URL as input, generate a short URL with a path made of a random sequence of 4 alphanumeric characters.

Example:

Input:
URL: http://looooong.com/somepath
Output:
URL: http://short.com/ZfGd

## 3 - Sequential keyword generation

Given two different instances of the service, the second one must use a different policy for the automatic keyword generation: an incremental integer from 1 to N

Example:

Input:
URL: http://looooong.com/somepath
Output:
URL: http://short.com/1
 */