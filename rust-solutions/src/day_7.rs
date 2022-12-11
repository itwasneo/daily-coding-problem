#[allow(dead_code)]
fn day_7(msg: String) -> u32 {
    let characters = msg.as_bytes();
    if characters.len() == 0 {
        0
    } else if characters.len() == 1 && characters[0] == b'0' {
        0
    } else {
        recursive_helper(characters, characters.len())
    }
}

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

#[cfg(test)]
mod tests {

    use super::day_7;

    #[test]
    pub fn day_7_test() {
        assert_eq!(3, day_7("111".to_owned()));
    }
}
