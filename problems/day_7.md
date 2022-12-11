# Good morning! Here's your coding interview problem for today

This problem was asked by <mark>&nbsp;Facebook&nbsp;</mark>

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.

## About Solution

* Check for the invalid cases and return 0 for them.

    * If the length of the character array is 0

    * Ih the length of the character array is 1 but 0th index is 0

* Write a helper recursive function that will traverse the string starting from the last index.

```rust
fn recursive_helper(char_buffer: &[u8], n: usize) -> u32 {
    if n == 0 || n == 1 {
        return 1;
    }
    let mut count: u32 = 0;

    if char_buffer[n - 1] > b'0' {
        count = recursive_helper(char_buffer, n - 1)
    }
    if char_buffer[n - 2] == b'1' || char_buffer[n - 2] == b'2' && char_buffer[n - 1] < b'7' {
        count += recursive_helper(char_buffer, n - 2)
    }

    return count;
}
```
[#medium]() [#recursion]() [#strings]()
